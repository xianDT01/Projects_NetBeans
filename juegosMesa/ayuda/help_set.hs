<helpset version="1.0">
	<title>Ayuda juegos de mesa</title>
	<maps>
		<homeID>presentacion</homeID>
		<mapref location="map_file.jhm"/>
	</maps>

	<!--Vistas de la ayuda-->

	<view>
		<name>Tabla Contenidos</name>
		<label>Tabla de contenidos</label>
		<type>javax.help.TOCView</type>
		<data>toc.xml</data>
	</view>

	<view>
		<name>Indice</name>
		<label>Nuestro índice</label>
		<type>javax.help.IndexView</type>
		<data>index.xml</data>
	</view>

	<view>
		<name>Buscar</name>
		<label>Busqueda</label>
		<type>javax.help.SearchView</type>
		<data engine="com.sun.java.help.search.DefaultSearchEngine">
			JavaHelpSearch
		</data>
	</view>

</helpset>
