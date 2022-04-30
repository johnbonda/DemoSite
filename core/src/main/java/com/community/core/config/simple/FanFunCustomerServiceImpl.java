package com.community.core.config.simple;

import org.broadleafcommerce.profile.core.domain.Customer;
import org.broadleafcommerce.profile.core.service.CustomerServiceImpl;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

public class FanFunCustomerServiceImpl extends CustomerServiceImpl {
    public FanFunCustomerServiceImpl() {
        System.out.println("FanFunCustomerServiceImpl created");
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        Customer retCustomer = super.saveCustomer(customer);
        System.out.println("Inside FanFunCustomerServiceImpl");
        if(!customer.isRegistered()) {
            notifyPostRegisterListeners(customer);
        }
        return retCustomer;
    }
}
