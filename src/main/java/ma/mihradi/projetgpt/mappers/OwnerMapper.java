package ma.mihradi.projetgpt.mappers;

import ma.mihradi.projetgpt.dtos.OwnerDto;
import ma.mihradi.projetgpt.entities.Owner;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class OwnerMapper {
    public Owner fromOwnerDto (OwnerDto ownerDto){
        Owner owner = new Owner();
        BeanUtils.copyProperties(ownerDto,owner);
        return owner;
    }

    public OwnerDto fromOwner (Owner owner){
        OwnerDto ownerDto = new OwnerDto();
        BeanUtils.copyProperties(owner,ownerDto);
        return ownerDto;
    }
}
