<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>
    <xsl:template match="/">
        <edix>
            <informacion>
                <grupo><xsl:value-of select="ite/empresa"/></grupo>
                <denominacion><xsl:value-of select="ite[@nombre]"/></denominacion>
                <www><xsl:value-of select="ite[@web]"/></www>
                <llama><xsl:value-of select="ite/telefono"/></llama>
            </informacion>

            <xsl:for-each select="ite/profesores">
                <claustro>
                    <maestro>
                        <xsl:attribute name="id">
                            <xsl:value-of select="ite/profesores/profesor/id"/>
                        </xsl:attribute>
                    
                        <xsl:attribute name="nombre">
                            <xsl:value-of select="ite/profesores/profesor/nombre"/>
                        </xsl:attribute>
                    </maestro>
                </claustro>
            </xsl:for-each>

            <gestiones>
                <responsable>
                    <xsl:attribute name="nombre">
                        <xsl:value-of select="ite/director/nombre"/>
                    </xsl:attribute>
                    <localizacion><xsl:value-of select="ite/director/despacho"/></localizacion>
                </responsable>

                <responsable>
                    <xsl:attribute name="nombre">
                        <xsl:value-of select="ite/jefe_estudios/nombre"/>
                    </xsl:attribute>
                    <localizacion><xsl:value-of select="ite/jefe_estudios/despacho"/></localizacion>
                </responsable>
            </gestiones>

            <xsl:for-each select="ite/ciclos">
                <estudios>
                    <curso>
                        <xsl:attribute name="nivel">
                            <xsl:value-of select="ite/ciclos/ciclo/grado"/>
                        </xsl:attribute>
                        <siglas><xsl:value-of select="ite/ciclos/ciclo[@id]"/></siglas>
                        <nombre_completo><xsl:value-of select="ite/ciclos/ciclo/nombre"/></nombre_completo>
                        <año_aprobacion><xsl:value-of select="ite/ciclos/ciclo/decretoTitulo[año]"/></año_aprobacion>
                    </curso>
                </estudios>
            </xsl:for-each>
        </edix>
    </xsl:template>
</xsl:stylesheet>