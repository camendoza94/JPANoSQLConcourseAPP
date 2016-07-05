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

import co.edu.uniandes.isis2503.basic.interfaces.ICompetitionConverter;
import co.edu.uniandes.isis2503.basic.model.dto.model.CompetitionDTO;
import co.edu.uniandes.isis2503.basic.model.entity.CompetitionEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luis Felipe Mendivelso Osorio <lf.mendivelso10@uniandes.edu.co>
 */
public class CompetitionConverter implements ICompetitionConverter{

    public static ICompetitionConverter CONVERTER = new CompetitionConverter();

    public CompetitionConverter() {
    }

    @Override
    public CompetitionDTO entityToDto(CompetitionEntity entity) {
        CompetitionDTO dto = new CompetitionDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCity(entity.getCity());
        dto.setCountry(entity.getCountry());
        dto.setPrize(entity.getPrize());
        dto.setYear(entity.getYear());
        dto.setCompetitors(entity.getCompetitors());
        dto.setWinnerId(entity.getWinnerId());
        return dto;
    }

    @Override
    public CompetitionEntity dtoToEntity(CompetitionDTO dto) {
        CompetitionEntity entity = new CompetitionEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCity(dto.getCity());
        entity.setCountry(dto.getCountry());
        entity.setPrize(dto.getPrize());
        entity.setYear(dto.getYear());
        entity.setCompetitors(dto.getCompetitors());
        entity.setWinnerId(dto.getWinnerId());

        return entity;
    }

    @Override
    public List<CompetitionDTO> listEntitiesToListDTOs(List<CompetitionEntity> entities) {
        ArrayList<CompetitionDTO> dtos = new ArrayList<>();
        for (CompetitionEntity entity : entities) {
            dtos.add(entityToDto(entity));
        }
        return dtos;
    }

    @Override
    public List<CompetitionEntity> listDTOsToListEntities(List<CompetitionDTO> dtos) {
        ArrayList<CompetitionEntity> entities = new ArrayList<>();
        for (CompetitionDTO dto : dtos) {
            entities.add(dtoToEntity(dto));
        }
        return entities;
    }
    
}
