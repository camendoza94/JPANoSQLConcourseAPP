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
package co.edu.uniandes.isis2503.basic.logic;

import co.edu.uniandes.isis2503.basic.interfaces.ICompetitorLogic;
import static co.edu.uniandes.isis2503.basic.model.dto.converter.CompetitorConverter.CONVERTER;
import co.edu.uniandes.isis2503.basic.model.dto.model.CompetitorDTO;
import co.edu.uniandes.isis2503.basic.persistence.CompetitorPersistence;
import java.util.List;

/**
 *
 * @author Luis Felipe Mendivelso Osorio <lf.mendivelso10@uniandes.edu.co>
 */
public class CompetitorLogic implements ICompetitorLogic {

    private final CompetitorPersistence persistence;

    public CompetitorLogic() {
        this.persistence = new CompetitorPersistence();
    }

    @Override
    public CompetitorDTO add(CompetitorDTO dto) {
        dto = CONVERTER.entityToDto(persistence.add(CONVERTER.dtoToEntity(dto)));
        return dto;
    }

    @Override
    public CompetitorDTO update(CompetitorDTO dto) {
        dto = CONVERTER.entityToDto(persistence.update(CONVERTER.dtoToEntity(dto)));
        return dto;
    }

    @Override
    public CompetitorDTO find(Long id) {
        return CONVERTER.entityToDto(persistence.find(id));
    }

    @Override
    public CompetitorDTO findByName(String name) {
        return CONVERTER.entityToDto(persistence.findByName(name));
    }

    @Override
    public CompetitorDTO findByEmail(String email) {
        return CONVERTER.entityToDto(persistence.findByEmail(email));
    }

    @Override
    public List<CompetitorDTO> all() {
        return CONVERTER.listEntitiesToListDTOs(persistence.all());
    }

    @Override
    public Boolean delete(CompetitorDTO dto) {
        return persistence.delete(CONVERTER.dtoToEntity(dto));
    }

}
