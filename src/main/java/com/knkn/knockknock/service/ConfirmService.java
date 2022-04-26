package com.knkn.knockknock.service;

import com.knkn.knockknock.CoolMessage;
import com.knkn.knockknock.KnKnUtility;
import com.knkn.knockknock.ResponseMessage;
import com.knkn.knockknock.controller.CustomResponseEntity;
import com.knkn.knockknock.domain.user.Confirm;
import com.knkn.knockknock.repository.userRepository.ConfirmRepository;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ConfirmService {

    private CoolMessage coolMessage = new CoolMessage();
    private final ConfirmRepository confirmRepository;

    public ConfirmService(ConfirmRepository confirmRepository) throws CoolsmsException {
        this.confirmRepository = confirmRepository;
    }

    public CustomResponseEntity<Confirm> sendMessage(String phoneNumber, String code) throws CoolsmsException {
        Confirm confirm = confirmRepository.findByPhoneNumberEquals(phoneNumber);

        //First Time
        if(confirm == null || confirm.getRequestTime() <= 10){

            try{
                coolMessage.sendSMS(phoneNumber,code);
                if(confirm == null) {
                    Confirm newConfirm = new Confirm();
                    newConfirm.setCreationTime(KnKnUtility.getCurrentTime());
                    newConfirm.setValidationNumber(code);
                    newConfirm.setPhoneNumber(phoneNumber);
                    confirmRepository.save(newConfirm);
                }
                else confirmRepository.updateValidation(code, confirm.getRequestTime() + 1, KnKnUtility.getCurrentTime(), phoneNumber);
            } catch (Exception e){
                System.out.println(e.getMessage());
            }

        } else return new CustomResponseEntity<>(400, ResponseMessage.MORE_THAN_TEN_TIMES_REQUEST,confirm);

        return new CustomResponseEntity<>(201, ResponseMessage.CONFIRM_CREATE_SUCCESS,confirm);
    }

    public boolean checkValidation(String phoneNumber, String code){
        Confirm confirm = confirmRepository.findByPhoneNumberEquals(phoneNumber);

        return confirm.getValidationNumber().equals(code);
    }

    public Confirm callConfirm(String phoneNumber){
        return confirmRepository.findByPhoneNumberEquals(phoneNumber);
    }
}
