/*
 * The MIT License
 *
 * Copyright 2016 Universidad De Los Andes - Departamento de Ingeniería de Sistemas.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package co.edu.uniandes.isis2503.basic.model.dto.converter;

import co.edu.uniandes.isis2503.basic.interfaces.ICompetitorConverter;
import co.edu.uniandes.isis2503.basic.model.dto.model.CompetitorDTO;
import co.edu.uniandes.isis2503.basic.model.entity.CompetitorEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Felipe Mendivelso Osorio <lf.mendivelso10@uniandes.edu.co>
 */
public class CompetitorConverter implements ICompetitorConverter {

    public static ICompetitorConverter CONVERTER = new CompetitorConverter();

    public CompetitorConverter() {
    }

    @Override
    public CompetitorDTO entityToDto(CompetitorEntity entity) {
        CompetitorDTO dto = new CompetitorDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setSurname(entity.getSurname());
        dto.setAge(entity.getAge());
        dto.setTelephone(entity.getTelephone());
        dto.setCellphone(entity.getCellphone());
        dto.setAddress(entity.getAddress());
        dto.setCity(entity.getCity());
        dto.setCountry(entity.getCountry());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    @Override
    public CompetitorEntity dtoToEntity(CompetitorDTO dto) {
        CompetitorEntity entity = new CompetitorEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        entity.setAge(dto.getAge());
        entity.setTelephone(dto.getTelephone());
        entity.setCellphone(dto.getCellphone());
        entity.setAddress(dto.getAddress());
        entity.setCity(dto.getCity());
        entity.setCountry(dto.getCountry());
        entity.setEmail(dto.getEmail());
        return entity;
    }

    @Override
    public List<CompetitorDTO> listEntitiesToListDTOs(List<CompetitorEntity> entities) {
        ArrayList<CompetitorDTO> dtos = new ArrayList<>();
        for (CompetitorEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Override
    public List<CompetitorEntity> listDTOsToListEntities(List<CompetitorDTO> dtos) {
        ArrayList<CompetitorEntity> entities = new ArrayList<>();
        for (CompetitorDTO dto : dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }

}
