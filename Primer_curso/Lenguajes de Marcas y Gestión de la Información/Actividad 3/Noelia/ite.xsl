<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="html" doctype-system="about:legacy-compat" encoding="UTF-8"/>
  <xsl:template match="/">
    <html>
      <head>
        <title>Instituto Tecnológico Edix</title>
        <style>
            body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            }

            h1, h2 {
            margin: 0;
            padding: 10px;
            }

            h1 {
            background-color: #333;
            color: white;
            }

            h2 {
            background-color: #eee;
            }

            table {
            border-collapse: collapse;
            width: 100%;
            }

            table, th, td {
            border: 1px solid black;
            }

            th, td {
            padding: 5px;
            }

            form label,
            form input,
            form textarea {
            display: block;
            margin-bottom: 10px;
            }

            form input[type="submit"] {
            cursor: pointer;
            }

        </style>
      </head>
      <body>
        <h1><xsl:value-of select="ite/@nombre"/></h1>
        <p>Empresa: <xsl:value-of select="ite/empresa"/></p>
        <p>Teléfono: <xsl:value-of select="ite/telefono"/></p>
        <h2>Profesores</h2>
        <table border="1">
          <tr>
            <th>ID</th>
            <th>Nombre</th>
          </tr>
          <xsl:for-each select="ite/profesores/profesor">
            <tr>
              <td><xsl:value-of select="id"/></td>
              <td><xsl:value-of select="nombre"/></td>
            </tr>
          </xsl:for-each>
        </table>
        <h2>Ciclos</h2>
        <table border="1">
          <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Grado</th>
            <th>Año de decreto de título</th>
          </tr>
          <xsl:for-each select="ite/ciclos/ciclo">
            <tr>
              <td><xsl:value-of select="@id"/></td>
              <td><xsl:value-of select="nombre"/></td>
              <td><xsl:value-of select="grado"/></td>
              <td><xsl:value-of select="decretoTitulo/@año"/></td>
            </tr>
          </xsl:for-each>
        </table>

         <!-- Enlaces -->
        <h2>Enlaces</h2>
        <ul>
          <li><a href="{ite/@web}">Sitio web del Instituto Tecnológico Edix</a></li>
          <li><a href="https://www.edix.com">Sitio web de Edix</a></li>
        </ul>

        <!-- Lista no ordenada -->
        <h2>Director y Jefe de estudios</h2>
        <ul>
          <li>Director: <xsl:value-of select="ite/director/nombre"/></li>
          <li>Jefe de estudios: <xsl:value-of select="ite/jefe_estudios/nombre"/></li>
        </ul>
        <!-- Lista ordenada -->
        <h2>Ciclos (lista ordenada)</h2>
        <ol>
        <xsl:for-each select="ite/ciclos/ciclo">
            <li><xsl:value-of select="nombre"/></li>
        </xsl:for-each>
        </ol>


        <!-- Formulario de contacto -->
        <h2>Formulario de contacto</h2>
        <form action="#" method="post">
          <label for="name">Nombre:</label><br/>
          <input type="text" id="name" name="name"/><br/>
          <label for="email">Correo electrónico:</label><br/>
          <input type="email" id="email" name="email"/><br/>
          <label for="message">Mensaje:</label><br/>
          <textarea id="message" name="message"></textarea><br/>
          <input type="submit" value="Enviar"/>
        </form>

        <!-- Aquí puedes agregar más contenido a la página web -->
      </body>
    </html>

  </xsl:template>

</xsl:stylesheet>

