package com.vmo.backendservices.service;

import com.vmo.backendservices.dto.DBFileDTO;
import com.vmo.backendservices.errors.FileStorageException;
import com.vmo.backendservices.errors.MyFileNotFoundException;
import com.vmo.backendservices.persistance.Domain.DBFile;
import com.vmo.backendservices.persistance.Repository.DBFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DBFileStorageService {

    @Autowired
    private DBFileRepository dbFileRepository;

    public DBFile storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequenth " + fileName);
            }

            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());

            return dbFileRepository.save(dbFile);

        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public DBFile getFile(String fileId) {
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }

    public void delete(String id) {
        dbFileRepository.deleteById(id);
    }

    public List<DBFileDTO> findFileDetails(){
        List<Object[]> files= dbFileRepository.getFileDeatils();
        List<DBFileDTO> dbFileDTOS = new ArrayList<>();
        files.stream().forEach(data->{
            DBFileDTO dbFileDTO = new DBFileDTO();
            dbFileDTO.setId(data[0].toString());
            dbFileDTO.setFileName(data[1].toString());
            dbFileDTO.setFileType(data[2].toString());
            dbFileDTOS.add(dbFileDTO);
        });
        return dbFileDTOS;
    }
}
