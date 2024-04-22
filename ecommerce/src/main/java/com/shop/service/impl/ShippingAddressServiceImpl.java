package com.shop.service.impl;

import com.shop.domain.dto.shippingaddress.ShippingAddressCreateUpdateDto;
import com.shop.domain.dto.shippingaddress.ShippingAddressDto;
import com.shop.domain.entity.ShippingAddressEntity;
import com.shop.domain.entity.UserEntity;
import com.shop.domain.exceptions.ClassicModelException;
import com.shop.repository.ShippingAddressRepository;
import com.shop.repository.UserRepository;
import com.shop.service.ShippingAddressService;
import com.shop.util.SecurityContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.shop.domain.mapper.ShippingAddressMapper.SHIPPING_ADDRESS_MAPPER;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {

    @Autowired
    private ShippingAddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityContextHelper securityContextHelper;

    @Override
    public List<ShippingAddressDto> getAllShippingAddress() {
        String email = securityContextHelper.getCurrentUserEmail();
        UserEntity user = userRepository.findByEmailAndEnabledIsTrue(email).orElseThrow(() -> new ClassicModelException("User not found to see shipping addresses"));
        List<ShippingAddressEntity> addressEntityList = addressRepository.findAllByEnabledIsTrueAndUserIdEquals(user.getId());
        return addressEntityList.stream().map(SHIPPING_ADDRESS_MAPPER::toDTO).collect(Collectors.toList());
    }

    @Override
    public void createShippingAddress(ShippingAddressCreateUpdateDto addressDto) {
        String email = securityContextHelper.getCurrentUserEmail();
        UserEntity user = userRepository.findByEmailAndEnabledIsTrue(email).orElseThrow(() -> new ClassicModelException("User not found to add an address"));

        Optional<ShippingAddressEntity> addressEntityOptional = addressRepository.findByAddressLine1AndUser(addressDto.getAddressLine1(), user);
        if (addressEntityOptional.isPresent()) {
            ShippingAddressEntity existingAddress = addressEntityOptional.get();
            if (existingAddress.isEnabled()) {
                throw new ClassicModelException("This address already exists, you can go to update if any data has changed");
            } else {
                ShippingAddressEntity updateAddress = SHIPPING_ADDRESS_MAPPER.toEntityCrud(addressDto);
                updateAddress.setId(existingAddress.getId());
                updateAddress.setUser(user);
                updateAddress.setAddressLine1(addressDto.getAddressLine1());
                updateAddress.setCreatedAt(existingAddress.getCreatedAt());
                updateAddress.setModifiedAt(LocalDateTime.now());
                updateAddress.setEnabled(true);
                addressRepository.save(updateAddress);
            }
        } else {
            ShippingAddressEntity addressToAdd = SHIPPING_ADDRESS_MAPPER.toEntityCrud(addressDto);
            addressToAdd.setUser(user);
            addressToAdd.setAddressLine1(addressDto.getAddressLine1());
            addressToAdd.setCreatedAt(LocalDateTime.now());
            addressToAdd.setEnabled(true);
            addressRepository.save(addressToAdd);
        }
    }

    @Override
    public void updateShippingAddress(ShippingAddressCreateUpdateDto addressDto, Integer addressId) {
        String email = securityContextHelper.getCurrentUserEmail();
        UserEntity user = userRepository.findByEmailAndEnabledIsTrue(email)
                .orElseThrow(() -> new ClassicModelException("User not found to add an address"));

        ShippingAddressEntity address = addressRepository.findByIdAndUserAndEnabledIsTrue(addressId, user)
                .orElseThrow(() -> new ClassicModelException("Does not exists for update!"));

        Optional<ShippingAddressEntity> addressLine1Used = addressRepository.findByUserAndAddressLine1AndIdNot(user, addressDto.getAddressLine1(), addressId);

        if (addressLine1Used.isPresent()) {
            if (addressLine1Used.get().isEnabled()) {
                throw new ClassicModelException("Address line 1 you provided already exists on your shipping addresses");
            } else {
                ShippingAddressEntity addressExistButDisabled = SHIPPING_ADDRESS_MAPPER.toEntityCrud(addressDto);
                addressExistButDisabled.setId(addressLine1Used.get().getId());
                addressExistButDisabled.setModifiedAt(LocalDateTime.now());
                addressExistButDisabled.setEnabled(true);
                addressExistButDisabled.setUser(addressLine1Used.get().getUser());
                addressExistButDisabled.setAddressLine1(addressLine1Used.get().getAddressLine1());
                addressExistButDisabled.setCreatedAt(addressLine1Used.get().getCreatedAt());
                addressRepository.save(addressExistButDisabled);

                address.setEnabled(false);
                address.setModifiedAt(LocalDateTime.now());
                addressRepository.save(address);
            }

        } else {
            ShippingAddressEntity updatedAddress = SHIPPING_ADDRESS_MAPPER.toEntityCrud(addressDto);
            updatedAddress.setId(address.getId());
            updatedAddress.setUser(user);
            updatedAddress.setCreatedAt(address.getCreatedAt());
            updatedAddress.setModifiedAt(LocalDateTime.now());
            updatedAddress.setAddressLine1(addressDto.getAddressLine1());
            updatedAddress.setEnabled(true);
            addressRepository.save(updatedAddress);
        }
    }

    @Override
    public void disableShippingAddress(Integer id, Boolean enabled) {
        ShippingAddressEntity address = addressRepository.findById(id).orElseThrow(() -> new ClassicModelException("Shipping Address with id " + id + " does not exists do be disabled"));
        if (enabled) {
            throw new ClassicModelException("Enabled should be false to disable shipping address");
        }
        address.setEnabled(false);
        addressRepository.save(address);
    }


    @Override
    public ShippingAddressEntity findAddressByIdAndUser(Integer addressId, UserEntity user) {
        return addressRepository.findByIdAndUserAndEnabledIsTrue(addressId, user)
                .orElseThrow(() ->new ClassicModelException("Shipping address was not found"));
    }
}
