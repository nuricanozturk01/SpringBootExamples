package org.csystem.animal.post.service;

import com.karandev.util.data.error.DataUtil;
import com.metemengen.animalhospital.data.dal.AnimalPostServiceHelper;
import com.metemengen.animalhospital.data.entity.orm.dto.AnimalWithOwnerSaveDTO;
import org.springframework.stereotype.Service;

@Service
public class AnimalPostService
{
    private final AnimalPostServiceHelper m_animalPostServiceHelper;

    public AnimalPostService(AnimalPostServiceHelper animalPostServiceHelper)
    {
        m_animalPostServiceHelper = animalPostServiceHelper;
    }

    public AnimalWithOwnerSaveDTO saveAnimalWithOwner(AnimalWithOwnerSaveDTO animalWithOwnerSaveDTO)
    {
        return DataUtil.doForDataService(() -> m_animalPostServiceHelper.saveAnimal(animalWithOwnerSaveDTO),
                "AnimalPostService.saveAnimalWithOwner");
    }

}
