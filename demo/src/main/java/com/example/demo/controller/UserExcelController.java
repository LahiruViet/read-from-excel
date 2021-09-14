package com.example.demo.controller;

import com.example.demo.dto.StudentDTO;
import com.example.demo.service.StudentExcelService;
import com.example.demo.service.impl.StudentExcelServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
@Slf4j
public class UserExcelController {


    @GetMapping("student/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=Student_Info_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        StudentExcelService studentExcelService = new StudentExcelServiceImpl();
        studentExcelService.exportToExcel(response);
    }

    @RequestMapping("/import/excel")
    @ResponseBody
    public String importFromExcel() throws IOException {

        StudentExcelService studentExcelService = new StudentExcelServiceImpl();
        List<StudentDTO> studentDTOs= studentExcelService.importFromExcel();
        System.out.println(studentDTOs);
        return "Import Successfully";
    }

}
