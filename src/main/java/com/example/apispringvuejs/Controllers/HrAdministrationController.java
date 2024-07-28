package com.example.apispringvuejs.Controllers;

import com.example.apispringvuejs.Dto.Dtohradministration;
import com.example.apispringvuejs.Service.Impl.HrAdministrationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/hradministrations")
@CrossOrigin(origins = "http://localhost:3030")
public class HrAdministrationController {
        @Autowired
        private HrAdministrationServiceImpl hrAdministrationServiceImpl;

        @GetMapping("/list")
        @ResponseBody
        public ResponseEntity<List<Dtohradministration>> getAllHradministration(){
            List<Dtohradministration> dtohradministrationList = this.hrAdministrationServiceImpl.getAllHrAdministration();
            if(dtohradministrationList != null) {
                return ResponseEntity.ok(dtohradministrationList);
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(dtohradministrationList);
            }
        }
        @PostMapping("/add")
        @ResponseBody
        public ResponseEntity createHradministration(@RequestBody() Dtohradministration dtohradministration){
            boolean isSuccess = this.hrAdministrationServiceImpl.createHrAdministrationDto(dtohradministration);
            System.out.println("GỌI" + isSuccess);
            if(isSuccess){
                return ResponseEntity.ok(isSuccess);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(isSuccess);
        }
        @GetMapping("/hradministration/{id}")
        @ResponseBody
        public ResponseEntity getHradministration (@PathVariable Long id){
            Dtohradministration dtohradministration = this.hrAdministrationServiceImpl.getHrAdministrationDtoById(id);
            if(dtohradministration != null){
                return ResponseEntity.ok(dtohradministration);
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Hradministration not found");
            }
        }
        @PutMapping("/update/{id}")
        @ResponseBody
        public ResponseEntity updateHradministration(@PathVariable Long id, @RequestBody Dtohradministration dtohradministration){
            dtohradministration.setId(id);
            boolean isSuccess = this.hrAdministrationServiceImpl.updateHrAdministrationDto(dtohradministration);
            System.out.println("Gọi Update Hradministration " + isSuccess);
            if(isSuccess){
                return ResponseEntity.ok(isSuccess);
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(isSuccess);
            }
        }
        @DeleteMapping("/delete/{id}")
        @ResponseBody
        public ResponseEntity deleteHradministration (@PathVariable Long id){
            boolean isSuccess = this.hrAdministrationServiceImpl.deleteHrAdministrationDto(id);
            System.out.println("Gọi Delete Hradministration" + isSuccess);
            if(isSuccess){
                return ResponseEntity.ok(isSuccess);
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(isSuccess);
            }
        }
}
