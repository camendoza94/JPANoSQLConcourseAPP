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
package co.edu.uniandes.isis2503.basic.service;

import co.edu.uniandes.isis2503.basic.interfaces.ICompetitionLogic;
import co.edu.uniandes.isis2503.basic.interfaces.ICompetitorLogic;
import co.edu.uniandes.isis2503.basic.logic.CompetitionLogic;
import co.edu.uniandes.isis2503.basic.logic.CompetitorLogic;
import co.edu.uniandes.isis2503.basic.model.dto.model.CompetitionDTO;
import co.edu.uniandes.isis2503.basic.model.dto.model.CompetitorDTO;
import com.sun.istack.logging.Logger;
import java.util.List;
import java.util.logging.Level;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Luis Felipe Mendivelso Osorio <lf.mendivelso10@uniandes.edu.co>
 */
@Path("/competitions")
@Produces(MediaType.APPLICATION_JSON)
public class CompetitionService {

    private final ICompetitionLogic competitionLogic;
    private final ICompetitorLogic competitorLogic;
    
    public CompetitionService(){
        this.competitionLogic = new CompetitionLogic();
        this.competitorLogic = new CompetitorLogic();
    }

    @POST
    public CompetitionDTO add(CompetitionDTO dto) {
        return competitionLogic.add(dto);
    }
    
    @POST
    @Path("{id}/add")
    public CompetitorDTO addCompetitor(@PathParam("id")Long id ,CompetitorDTO dto) {
        CompetitionDTO competition = competitionLogic.find(id);
        dto=competitorLogic.add(dto);
        competition.addCompetitor(dto.getId());
        competitionLogic.update(competition);
        return dto;
    }

    @PUT
    public CompetitionDTO update(CompetitionDTO dto) {
        return competitionLogic.update(dto);
    }

    @GET
    @Path("/{id}")
    public CompetitionDTO find(@PathParam("id") Long id) {
        return competitionLogic.find(id);
    }

    @GET
    @Path("/name={name}")
    public CompetitionDTO findByName(@PathParam("name") String name) {
        return competitionLogic.findByName(name);
    }

    @GET
    public List<CompetitionDTO> all() {
        return competitionLogic.all();
    }

    @DELETE
    public Response delete(CompetitionDTO dto) {
        try {
            competitionLogic.delete(dto);
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity("Sucessful: Competition was deleted").build();
        } catch (Exception e) {
            Logger.getLogger(CompetitionService.class).log(Level.WARNING, e.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin", "*").entity("We found errors in your query, please contact the Web Admin.").build();
        }
    }

}

