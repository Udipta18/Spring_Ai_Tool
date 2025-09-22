package com.eazybytes.springai.tools;

import com.eazybytes.springai.entity.HelpDeskTicket;
import com.eazybytes.springai.model.TbDetails;
import com.eazybytes.springai.model.TicketRequest;
import com.eazybytes.springai.service.HelpDeskTicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.model.ToolContext;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TBTools {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelpDeskTools.class);

//    private final HelpDeskTicketService service;

    @Tool(name = "createTbData", description = "Create data for run the batches on top of that", returnDirect = true)
    String createTicket(@ToolParam(description = "Details to create a Support ticket")
                        TbDetails ticketRequest, ToolContext toolContext) {
        String username = (String) toolContext.getContext().get("username");
        LOGGER.info("Creating support ticket for user: {} with details: {}", username, ticketRequest);
//        HelpDeskTicket savedTicket = service.createTicket(ticketRequest,username);
//        LOGGER.info("Ticket created successfully. Ticket ID: {}, Username: {}", savedTicket.getId(), savedTicket.getUsername());
        return "Data Inserted Successfully";
    }

    @Tool(name= "runTheBatches", description = "Run the batches on the TB data")
    String runTheBatches(ToolContext toolContext) {
        String username = (String) toolContext.getContext().get("username");
        LOGGER.info("Run The Batches: {}", username);
//        List<HelpDeskTicket> tickets =  service.getTicketsByUsername(username);
//        LOGGER.info("Found {} tickets for user: {}", tickets.size(), username);
//        // throw new RuntimeException("Unable to fetch ticket status");
        return  "Batch Run Successfully";
    }


    @Tool(name= "validateData", description = "validate the data after batch run")
    String validateData(ToolContext toolContext) {
        String username = (String) toolContext.getContext().get("username");
        LOGGER.info("Validate The data: {}", username);
//        List<HelpDeskTicket> tickets =  service.getTicketsByUsername(username);
//        LOGGER.info("Found {} tickets for user: {}", tickets.size(), username);
//        // throw new RuntimeException("Unable to fetch ticket status");
        return  "Validate data Successfully";
    }



}
