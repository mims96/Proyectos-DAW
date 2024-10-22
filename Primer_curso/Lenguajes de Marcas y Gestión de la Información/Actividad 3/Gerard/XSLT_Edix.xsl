<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <head>
                <title>Escuela Edix</title>
                <link rel="stylesheet" href="Edix.css"></link>
            </head>
            <header>
                <a href="https://www.edix.com/es/" target="_blank">
                <h1>
                    <xsl:for-each select="ite">
                        <xsl:value-of select="@nombre"/>
                    </xsl:for-each>
                </h1>
                </a>
                <h2><xsl:value-of select="ite/empresa"/></h2>
                <h3><xsl:value-of select="ite/telefono"/></h3>
            </header>
            <body>
                <section>
                    <table class="profesores">
                        <thead>
                            <tr><th colspan="2" class="profesorado">Profesorado</th></tr>
                            <tr>
                                <th>Id_Profesor</th>
                                <th>Nombre Profesor</th>
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
                    <table class="cursos">
                        <thead>
                            <tr>
                                <th colspan="4" class="imparten">Cursos que Imparte el Centro</th>
                            </tr>
                            <tr>
                                <th>Cursos</th>
                                <th>Nombre del Curso</th>
                                <th>Grado</th>
                                <th>Decreto</th>
                            </tr>
                        </thead>
                        <tbody>
                            <xsl:for-each select="ite/ciclos/ciclo">
                                <tr>
                                    <td><a href="https://www.edix.com/es/fp/" target="_blank">
                                        <xsl:value-of select="@id"/>
                                    </a></td>
                                    <td><xsl:value-of select="nombre"/></td>
                                    <td><xsl:value-of select="grado"/></td>
                                    <td><xsl:for-each select="decretoTitulo">
                                        <xsl:value-of select="@año"/>
                                    </xsl:for-each> 
                                    </td>
                                </tr>
                            </xsl:for-each>
                        </tbody>
                    </table>
                </section>
                <section class="Equipo">
                    <h1>Nuestro Equipo</h1>
                    <ol class="lista">
                        <li>Director: <xsl:value-of select="ite/director/nombre"/>
                            <xsl:value-of select="ite/director/despacho"/>
                        </li>
                       <li> Jefe de Estudios: <xsl:value-of select="ite/jefe_estudios/nombre"/>
                            <xsl:value-of select="ite/jefe_estudios/despacho"/>
                            
                       </li>
                    </ol>
                    <div class="directora">
                        <img  src="img\Directora.jpg"/>
                    </div>
                    <div class="jefeEstudios">
                        <img  src="img\jefe_estudios.jpg"/>
                    </div>
                    
                </section>
            </body>
            <footer>
                <h2>Para recibir información sobre algun curso contacte con nosotros</h2>
                <form action="procesarPeticion.jsp" method="post">
                    <div class="formulario">
                        <label for="nombre">Nombre: </label>
                        <input id="nombre" type="text" name="nombre"/><br/><br/>
                        <label for="1apellido">Primer Apellido: </label>
                        <input id="1apellido" type="text" name="1apellido"/><br/><br/>
                        <label for="2apellido">Segundo Apellido: </label>
                        <input id="2apellido" type="text" name="2apellido"/><br/><br/>
                        <label for="email">Email: </label>
                        <input id="email" type="email" name="email"/><br/><br/>
                        <label for="telefono">Telefono: </label>
                        <input id="telefono" type="telefono" name="telefono"/><br/><br/>
                        </div>
                    <label for="curso">Selecciona Curso </label>
                    <select name="curso">
                        <option value="asir">ASIR</option>
                        <option value="daw">DAW</option>
                        <option value="dam">DAM</option>
                    </select><br/><br/>
                    <div class="enviar">
                        <input type="submit" value="Pedir Informacion"/>
                    </div>
                </form>
            </footer>
        </html>
    </xsl:template>
</xsl:stylesheet>