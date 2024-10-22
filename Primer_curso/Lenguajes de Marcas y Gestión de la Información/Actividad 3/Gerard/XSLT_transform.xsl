<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
    <xsl:template match="/">
        <escuela>
            <nombre><xsl:value-of select="ite/@nombre"/></nombre>
            <web><xsl:value-of select="ite/@web"/></web>
            <empresa>
                <xsl:attribute name="tel">
                    <xsl:value-of select="ite/telefono"/>
                </xsl:attribute>
                <xsl:value-of select="ite/empresa"/>
            </empresa>

            
            <profesorado>
                <xsl:for-each select="ite/profesores/profesor">
                <profesor>
                    <xsl:attribute name="id">
                        <xsl:value-of select="id"/>
                    </xsl:attribute>
                    <nombre><xsl:value-of select="nombre"/></nombre>
                </profesor>
                </xsl:for-each>
            </profesorado>

             <equipoDirectivo>
                <director>
                    <nombre><xsl:value-of select="ite/director/nombre"/></nombre>
                    <oficina><xsl:value-of select="ite/director/despacho"/></oficina>
                </director>

                <jefeEstudios>
                    <nombre><xsl:value-of select="ite/jefe_estudios/nombre"/></nombre>
                    <oficina><xsl:value-of select="ite/jefe_estudios/despacho"/></oficina>
                </jefeEstudios>
            </equipoDirectivo>


           
           
                <gradosFormativos>
                    <xsl:for-each select="ite/ciclos/ciclo">
                        <grado>
                            <xsl:attribute name="nivel">
                                <xsl:value-of select="grado"/>
                            </xsl:attribute>
                            <nombre>
                            <xsl:attribute name="id">
                                <xsl:value-of select="@id"/>
                            </xsl:attribute>
                            <xsl:attribute name="ano">
                                <xsl:value-of select="decretoTitulo/@ano"/>
                            </xsl:attribute>
                            <xsl:value-of select="nombre"/>
                            </nombre>
                        </grado>
                    </xsl:for-each>
                </gradosFormativos>
            
        </escuela>
    </xsl:template>
</xsl:stylesheet>