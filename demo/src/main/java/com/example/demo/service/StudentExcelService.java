package com.example.demo.service;

import com.example.demo.dto.StudentDTO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface StudentExcelService {

    void exportToExcel(HttpServletResponse response) throws IOException;

    List<StudentDTO> importFromExcel() throws IOException;
}
