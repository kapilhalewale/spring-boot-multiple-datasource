package com.kp.multipledatasources.sample.repository.mysqlrepository;

import com.kp.multipledatasources.sample.entity.mysql.AttendanceMySql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceMySqlRepository extends JpaRepository<AttendanceMySql, Long> {
}