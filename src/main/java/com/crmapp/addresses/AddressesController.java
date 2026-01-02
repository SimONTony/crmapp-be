package com.crmapp.addresses;

import com.crmapp.core.response.dto.BaseResponseDto;
import com.crmapp.core.response.dto.ResultDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("address")
public class AddressesController {

//    @Qualifier("AddressServiceImplVer2")
    private final AddressService addressService;

    @Autowired
    public AddressesController(AddressServiceImpl addressService) {
        this.addressService = addressService;
    }

    @GetMapping("all")
    public BaseResponseDto<List<AddressDto>> getAllAddresses() {
        return new BaseResponseDto<>(addressService.getAllAddresses());

    }

    @GetMapping(value = "{addressId}")
    public BaseResponseDto<AddressDto> getAddressById(@PathVariable Long addressId) {
        AddressDto address = addressService.getAddressById((addressId));
        return new BaseResponseDto<>(address);
    }

    @DeleteMapping(value = "{addressId}")
    public ResultDto deleteAddress(@PathVariable Long addressId) {
        addressService.delete(addressId);
        return new ResultDto("success");
    }

    @PostMapping(value = "add")
    public BaseResponseDto<AddressDto> addAddress(@RequestBody AddressDto addressDto) {
        AddressDto saveAddress = addressService.addAddress(addressDto);
        return new BaseResponseDto<>(saveAddress);
    }

    @PutMapping(value = "edit")
    public BaseResponseDto<AddressDto> editAddress(@RequestBody AddressDto addressDto) {
        AddressDto updatedAddress = addressService.editAddress(addressDto);
        return new BaseResponseDto<>(updatedAddress);
    }

}
