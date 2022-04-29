package com.community.core.config.simple;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.broadleafcommerce.common.presentation.AdminPresentation;
import org.broadleafcommerce.common.presentation.AdminPresentationClass;
import org.broadleafcommerce.common.presentation.override.AdminPresentationMergeEntry;
import org.broadleafcommerce.common.presentation.override.AdminPresentationMergeOverride;
import org.broadleafcommerce.common.presentation.override.AdminPresentationMergeOverrides;
import org.broadleafcommerce.common.presentation.override.PropertyType;
import org.broadleafcommerce.profile.core.domain.CustomerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "FanFunCustomer")
@AdminPresentationClass(ceilingDisplayEntity = "com.community.core.config.simple.FanFunCustomerImpl")
@AdminPresentationMergeOverrides({
		@AdminPresentationMergeOverride(name = "FanFunCustomerImpl.MobileNumber", mergeEntries = {
				@AdminPresentationMergeEntry(propertyType = PropertyType.AdminPresentation.EXCLUDED, booleanOverrideValue = false) }) })

public class FanFunCustomerImpl extends CustomerImpl implements FanFunCustomer {
	@Autowired
	

	private static final long serialVersionUID = 1L;
	@Column(name = "MOBILE_NUMBER")
	@AdminPresentation(friendlyName = "Mobile_Number", group = GroupName.ContactInfo, order = FieldOrder.PHONES, prominent = true, gridOrder = 1000)
	private Long mobileNumber;

	@Override
	public Long getMobileNumber() {
		return mobileNumber;
	}

	@Override
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

}
