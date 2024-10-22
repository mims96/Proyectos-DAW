<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <!-- .......................Título de página y cabecera........................................... -->
            <head>
                <title>EDIX</title>
                <link rel="stylesheet" href="edix1.css" />
            </head>
            
            <header>
            <h1><b><xsl:value-of select="ite/@nombre"/></b></h1>
            <h2><b>Ciclos superiores a distancia</b></h2>
            </header>

            <!-- .......................Texto, tablas y fotografías............................................-->
            <body>
                <h2><marquee>🚀Adelántate al futuro en 2 años🚀</marquee></h2>
                <br></br>
                <section>
                    <div class="primerparr">
                        <p>
                            <i>
                                Cada año que pasa es más importante contar con una formación sólida en las nuevas tecnologías.
                                Ante la creciente demanda de profesionales formados en este sector, cursar uno de los siguientes
                                ciclos formativos será un acierto seguro. 
                            </i>
                        </p>
                    </div>
                    
                    <br></br>  
                    <img class ="foto2" src="img/vm.png" alt="Programando"/>  
                    <div class="resumen"><p>A continuación se expone un resumen visual de nuestra oferta formativa:</p></div>                                    
                </section>
                <br></br> 

                <section>
                    <article>
                        <table border="1">
                            <caption><b>Ciclos superiores ofertados</b></caption>
                            <thead>
                                <tr>
                                    <th>Siglas</th>
                                    <th>Nombre completo</th>
                                    <th>Tipo de ciclo</th>
                                    <th>Oficial desde</th>
                                </tr>
                            </thead>
                            <tbody>
                                <xsl:for-each select="ite/ciclos/ciclo">
                                    <tr>
                                        <td><xsl:value-of select="@id"/></td>
                                        <td><xsl:value-of select="nombre"/></td>
                                        <td><xsl:value-of select="grado"/></td>
                                        <td><xsl:value-of select="decretoTitulo/@año"/></td>
                                    </tr>
                                </xsl:for-each>
                            </tbody>
                    </table>
                    <p class="enlace1">Para saber más <a href="https://institutotecnologico.edix.com">bucea por la web</a></p>
                    </article>
                    <br></br>
                    <br></br>

                    <article>
                        <div class="primerparr">
                            <p>
                                <i>                                    
                                    ~~ La calidad de un curso no reside exclusivamente en su contenido, 
                                    sino también en el compromiso del profesorado que te acompaña ~~                                    
                                </i>
                            </p>
                        </div> 
                        <br></br>
                        <img class ="foto1" src="img/desweb2.png" alt="Infografía lenguajes de programación"/>
                        <br></br>
                        <table class="tabla2" border="1">
                            <br></br>
                            <caption><b>Claustro</b></caption>
                            <thead>
                                <tr>
                                    <th>Nº</th>
                                    <th>Nombre</th>
                                </tr>
                            </thead>
                            <tbody>
                                <xsl:for-each select="ite/profesores/profesor">
                                    <tr>
                                        <td><xsl:value-of select="id"/></td>
                                        <td><xsl:value-of select="nombre"/></td>
                                    </tr>
                                </xsl:for-each>
                            </tbody>
                        </table>
                    </article>
                </section>
                <br></br>
                <br></br>
                <br></br>
                <br></br>
                <br></br>
                <br></br>
                                                     
                <!-- ..........................................Formulario................................................. -->
                <section>
                    <p class="contactus">Si deseas recibir más información, ponte en contacto con nosotros:</p>
                    <h2 class="formulario">💡Formulario de contacto</h2>
                    <form action="procesarPeticion.jsp" method="post">
                        <fieldset>
                            <label for="nombre">Nombre: </label>
                            <input id="nombre" type="text" name="nombre"/>
                            <br/>
                            <label for="apellidos">Apellidos: </label>
                            <input id="apellidos" type="text" name="apellidos"/>
                            <br/>
                            <label for="edad">Edad: </label>
                            <input id="edad" type="number" name="edad" />
                            <br/>
                            <label for="email">Correo electrónico: </label>
                            <input id="email" type="text" name="email"/>
                            <br/>
                            <label for="telf">Teléfono: </label>
                            <input id="telf" type="tel" name="telf"/>
                            <br/>
                            <label for="municipio">Municipio: </label>
                            <input id="municipio" type="text" name="municipio" />
                            <br/>
                            <label for="pais">País: </label>
                            <input id="pais" type="text" name="pais" />
                            <br/>
                            <br></br>

                            <label for="estudios">Últimos estudios finalizados: </label>
                            <select name="estudios">
                                <option value="eso">Educación Secundaria Obligatoria</option>
                                <option value="medio" >Ciclo Formativo de Grado Medio</option>
                                <option value="bachillerato">Bachillerato</option>
                                <option value="cisup">Ciclo Formativo de Grado Superior</option>
                                <option value="superior">Educación superior</option>
                            </select>
                            <br/> 

                            <label for="interes">Ciclo formativo de interés: </label>
                            <select name="interes">
                                <option value="daw">DAW</option>
                                <option value="dam" >DAM</option>
                                <option value="asir">ASIR</option>
                            </select>
                
                            <br/>
                            <label for="comentarios">Comentarios: </label>
                            <br />
                            <textarea style="resize: none;" rows="7" cols="80" name="comentarios"></textarea>

                            <br/>
                            <br/>	
                            He leido y acepto los terminos de uso <input type="checkbox" name="terminos" value="Y" />
                            <br/>	
                            <br/>	
                            <input type="submit" value="Enviar" />
                            <input type="reset" value="Borrar formulario" />
                        </fieldset>
                    </form>
                </section>
                <br></br>
                <div class="barra"></div>
            </body>

            <!-- ................................Pie de página.............................................-->
            <footer>
                <h3><u>Información general</u></h3>
                <p>💼<xsl:value-of select="ite/empresa"/></p>
                <p>📞<xsl:value-of select="ite/telefono"/></p>
                <a href="https://institutotecnologico.edix.com">🖥️ Web del grupo</a>
                <br></br>
                <br></br>
 
                <div class="lista">
                        <article>
                            <h3 class="jefes"><i>Dirección</i></h3>
                            <ol>
                                <li><xsl:value-of select="ite/director/nombre"/></li>
                                <li><xsl:value-of select="ite/director/despacho"/></li>
                            </ol>
                        </article>
                        <br></br>

                        <article>
                            <h3 class="jefes"><i>Jefatura de estudios</i></h3>
                            <ol>
                                <li><xsl:value-of select="ite/jefe_estudios/nombre"/></li>
                                <li><xsl:value-of select="ite/jefe_estudios/despacho"/></li>
                            </ol>
                        </article>
                    </div>
            </footer>
        </html>
    </xsl:template>
</xsl:stylesheet>  