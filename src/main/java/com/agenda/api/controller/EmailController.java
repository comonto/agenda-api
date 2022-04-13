package com.agenda.api.controller;

import java.util.List;

import com.agenda.business_logic.dto.EmailDTO;
import com.agenda.business_logic.service.EmailService;
import com.agenda.data_model.model.email.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 */
@RestController
@RequestMapping(value="api/contact/{contactId}/email")
public class EmailController {

    @Autowired
    EmailService emailService;

    /**
     * 
     * @param contactId
     * @param isPaged
     * @param pageable
     * @return
     */
    @GetMapping(value="/")
    public List<Email> getEmails(@RequestParam Long contactId, 
                                // @RequestParam(name="isPaged", defaultValue = "false", required = false) Boolean isPaged,
                                @PageableDefault(page = 0, size = 50) Pageable pageable) {
        return emailService.getEmails(contactId, pageable);
    
    }
}
