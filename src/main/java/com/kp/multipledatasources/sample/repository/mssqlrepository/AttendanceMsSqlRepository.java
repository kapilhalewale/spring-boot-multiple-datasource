package com.kp.multipledatasources.sample.repository.mssqlrepository;

import com.kp.multipledatasources.sample.entity.mssql.AttendanceMSql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AttendanceMsSqlRepository extends JpaRepository<AttendanceMSql, Long> {
}