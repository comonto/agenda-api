package com.agenda.api.controller;

import java.util.Optional;

import com.agenda.business_logic.dto.ContactDTO;
import com.agenda.business_logic.service.ContactService;
import com.agenda.data_model.model.contact.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * 
 */
@RestController
@RequestMapping(value="api/contact")
public class ContactController {

    @Autowired
    ContactService contactService;

    /**
     * http POST call that take in input
     * @param contactDto
     * @apiNote to create a new contact for the agenda
     * @return contactId
     */
    @PostMapping(value="/")
    public Long createContact(@RequestBody ContactDTO contactDto) {
        return contactService.createContact(contactDto);
    }
    
    // @RequestMapping(value = {"/{id}"}, method = RequestMethod.GET)
    // public Page<ContactDTO> readAllContact(@PathVariable(value = "id", required = false) Long contactId ) {
    //     if (contactId == null) {
    //         return contactService.readOneContact(contactId);
    //     } else {
    //         return contactService.readAllContact();
    //     }
    // }

    /**
     * http GET call that 
     * @return a paged list of all contacts
     */
    @GetMapping(value="/")
    public Page<ContactDTO> readAllContact(@PageableDefault(page = 0, size = 100) Pageable pageable) {
        return contactService.readAllContact(pageable);
    }

    /**
     * http GET call that take in input
     * @param id
     * @return a contact
     */
    @GetMapping(value="/{id}")
    public ContactDTO readOneContact(@RequestParam Long id) {
        return contactService.readOneContact(id);
    }
    
    /**
     * http PUT call that take in input
     * @param id
     * @param contactDto
     * @apiNote and update a contact and his relative info (emails and phone numbers)
     */
    @PutMapping(value="/{id}")
    public void updateContact(@PathVariable Long id, @RequestBody ContactDTO contactDto) {
       contactService.updateContact(id, contactDto);
    }

    /**
     * http DELETE call that take in input
     * @param id
     * @apiNote and delete a contact
     */
    @PutMapping(value="/{id}")
    public void deleteContact(@PathVariable Long id) {
       contactService.deleteContact(id);
    }

}
