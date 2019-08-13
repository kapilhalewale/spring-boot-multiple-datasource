package com.kp.multipledatasources.sample.resource;


import com.kp.multipledatasources.sample.entity.mssql.AttendanceMSql;
import com.kp.multipledatasources.sample.entity.mysql.AttendanceMySql;
import com.kp.multipledatasources.sample.repository.mssqlrepository.AttendanceMsSqlRepository;
import com.kp.multipledatasources.sample.repository.mysqlrepository.AttendanceMySqlRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AttendanceController {

    @Autowired
    private AttendanceMySqlRepository attendanceMySqlRepository;

    @Autowired
    private AttendanceMsSqlRepository attendanceMsSqlRepository;


    @PostMapping("/mysql")
    public ResponseEntity<AttendanceMySql> saveToMySql(@RequestBody AttendanceMySql attendanceMySql){

        AttendanceMySql attendanceMySql1 = attendanceMySqlRepository.save(attendanceMySql);
        return new ResponseEntity<>(attendanceMySql1, HttpStatus.CREATED);
    }

    @GetMapping("/mysql")
    public ResponseEntity<List<AttendanceMySql>> fetchMysqlData(){
        List<AttendanceMySql> data = attendanceMySqlRepository.findAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @PostMapping("/mssql")
    public ResponseEntity<AttendanceMSql> saveToMsSql(@RequestBody AttendanceMSql attendanceMSql){

        System.out.println("Data" + attendanceMSql.getName());
        AttendanceMSql data = attendanceMsSqlRepository.save(attendanceMSql);
        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    @GetMapping("/mssql")
    public ResponseEntity<List<AttendanceMSql>> fetchMssqlData(){
        List<AttendanceMSql> data = attendanceMsSqlRepository.findAll();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}