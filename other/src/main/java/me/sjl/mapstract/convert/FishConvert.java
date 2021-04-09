package me.sjl.mapstract.convert;

import me.sjl.mapstract.dto.FishTankWithVolumeDto;
import me.sjl.mapstract.dto.VolumeDto;
import me.sjl.mapstract.entity.FishTank;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface FishConvert {

    @Mapping(target = "volume", source = "fishTank")
    FishTankWithVolumeDto map(FishTank fishTank);

    default VolumeDto mapVolume(FishTank fishTank) {
        int volume = fishTank.length * fishTank.width * fishTank.height;
        String desc = volume < 100 ? "Small" : "Large";
        return new VolumeDto(volume, desc);
    }
}
