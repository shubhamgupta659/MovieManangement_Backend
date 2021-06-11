package com.vmo.backendservices.persistance.Repository;

import com.vmo.backendservices.persistance.Domain.DBFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {

    @Query(value="select f.id, f.fileName ,f.fileType from DBFile f")
    List<Object[]> getFileDeatils();
}