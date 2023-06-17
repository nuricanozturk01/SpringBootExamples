package org.csystem.app.service.animalhospital.veterinarian.controller;

import com.karandev.util.exception.ExceptionUtil;
import org.csystem.app.service.animalhospital.veterinarian.dto.*;
import org.csystem.app.service.animalhospital.veterinarian.mapper.IVeterinarianMapper;
import org.csystem.app.service.animalhospital.veterinarian.service.VeterinarianService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/vets/get")
public class VeterinarianController
{
    private final VeterinarianService m_veterinarianService;
    private final IVeterinarianMapper m_veterinarianMapper;

    public VeterinarianController(VeterinarianService veterinarianService, IVeterinarianMapper VeterinarianMapper)
    {
        m_veterinarianService = veterinarianService;
        m_veterinarianMapper = VeterinarianMapper;
    }

    @GetMapping("count")
    public CountDTO count()
    {
        return m_veterinarianService.countVeterinarians();
    }
    //------------------------------------------------------------------------------------
    @GetMapping("vet/diploma/200")
    public ResponseEntity<VeterinarianDTO> findByDiplomaNo(@RequestParam("no") long number)
    {
        return ResponseEntity.of(m_veterinarianService.findVeterinarianByDiplomaNo(number));
    }

    @GetMapping("vet/diploma/obj")
    public Object findByDiplomaNoObj(@RequestParam("no") long number)
    {
        var result = m_veterinarianService.findVeterinarianByDiplomaNo(number);
        return result.isPresent() ? result.get() : new VeterinarianStatus("Veterinarian Not found!", number);
    }

    @GetMapping("vet/diploma/200/status")
    public VeterinarianStatusDTO findByDiplomaNoWithStatus(@RequestParam("no") long number)
    {
        var result = m_veterinarianService.findVeterinarianByDiplomaNo(number);
        return result.isPresent() ? m_veterinarianMapper.toVeterinarianStatusDTO(result.get()) : new VeterinarianStatusDTO(false);
    }

    @GetMapping("vet/diploma")
    public ResponseEntity<Object> findByDiplomaNo(@RequestParam("no") String number)
    {
        ResponseEntity<Object> result;

        try
        {
            var info =  m_veterinarianService.findVeterinarianByDiplomaNo(Long.parseLong(number));
            result = ResponseEntity.ok(info.isPresent() ? m_veterinarianMapper.toVeterinarianStatusDTO(info.get()) : new VeterinarianStatusDTO(false));
        }
        catch (NumberFormatException ignore)
        {
            result = ResponseEntity.badRequest().body(new VeterinarianError("Invalid Diploma No", HttpStatus.BAD_REQUEST.value()));
        }
        catch (Throwable ignored)
        {
            result = ResponseEntity.internalServerError().body(new VeterinarianError("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR.value()));
        }

        return result;
    }
    //------------------------------------------------------------------------------------

    @GetMapping("lastname")
    public VeterinariansDTO findByLastName(@RequestParam("n") String lastName)
    {
        return m_veterinarianService.findVeterinariansByLastName(lastName);
    }

    @GetMapping("monthyear")
    public VeterinariansDTO findByMonthAndYear(@RequestParam("m") int month, @RequestParam("y") int year)
    {
        return m_veterinarianService.findVeterinariansByMonthAndYear(month, year);
    }

    @GetMapping("between/year")
    public VeterinariansWithFullNameDTO findByYearBetween(@RequestParam("begin") int begin, @RequestParam("end") int end)
    {
        return m_veterinarianService.findVeterinariansByYearBetween(begin, end);
    }

    /*@PostMapping("vet/save")
    public VeterinarianSaveDTO save(@RequestBody VeterinarianSaveDTO veterinarianSave)
    {
        return m_veterinarianService.saveVeterinarian(veterinarianSave);
    }*/


    @GetMapping("year")
    public VeterinariansDTO findVeterinariansByYear(@RequestParam("y") int year)
    {
        return m_veterinarianService.findVeterinarianByYear(year);
    }

    @GetMapping("month")
    public VeterinariansDTO findVeterinariansByMonth(@RequestParam("m") int month)
    {
        return m_veterinarianService.findVeterinarianByMonth(month);
    }

    @GetMapping("all")
    public VeterinariansDTO findAllVeterinarians()
    {
        return m_veterinarianService.findAllVeterinarians();
    }

    @GetMapping("name/full")
    public ResponseEntity<Object> findAllWithFullName() {
        return ExceptionUtil.subscribe(() -> ResponseEntity.ok(m_veterinarianService.findAllVeterinariansWithFullName()),
                ignore -> ResponseEntity.internalServerError().body(new VeterinarianError("Internal problem occurs!...Try again later", HttpStatus.INTERNAL_SERVER_ERROR.value())));
    }
}
