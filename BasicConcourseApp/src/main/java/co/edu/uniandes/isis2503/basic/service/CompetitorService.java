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

import co.edu.uniandes.isis2503.basic.interfaces.ICompetitorLogic;
import co.edu.uniandes.isis2503.basic.logic.CompetitorLogic;
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
@Path("/competitors")
@Produces(MediaType.APPLICATION_JSON)
public class CompetitorService {

    private final ICompetitorLogic logic;
    
    public CompetitorService(){
        this.logic = new CompetitorLogic();
    }

    @POST
    public CompetitorDTO add(CompetitorDTO dto) {
        return logic.add(dto);
    }

    @PUT
    public CompetitorDTO update(CompetitorDTO dto) {
        return logic.update(dto);
    }

    @GET
    @Path("/{id}")
    public CompetitorDTO find(@PathParam("id") Long id) {
        return logic.find(id);
    }

    @GET
    @Path("/name={name}")
    public CompetitorDTO findByName(@PathParam("name") String name) {
        return logic.findByName(name);
    }

    @GET
    @Path("/email={email}")
    public CompetitorDTO findByEmail(@PathParam("email") String email) {
        return logic.findByEmail(email);
    }

    @GET
    public List<CompetitorDTO> all() {
        return logic.all();
    }

    @DELETE
    public Response delete(CompetitorDTO dto) {
        try {
            logic.delete(dto);
            return Response.status(200).header("Access-Control-Allow-Origin", "*").entity("Sucessful: Competitor was deleted").build();
        } catch (Exception e) {
            Logger.getLogger(CompetitorService.class).log(Level.WARNING, e.getMessage());
            return Response.status(500).header("Access-Control-Allow-Origin", "*").entity("We found errors in your query, please contact the Web Admin.").build();
        }
    }

}
