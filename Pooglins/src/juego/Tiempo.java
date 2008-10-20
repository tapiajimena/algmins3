package juego;
//Class tiempo preliminar

public class Tiempo {
	
private double segundos;

private double minutos;

private double horas;



public Tiempo(double segundos, double minutos ,double horas)
{
this.segundos=segundos;
this.minutos=minutos;
this.horas=horas;
}


public void setSegundos(double segundos)
{
	this.segundos =  segundos;
}


public void setMinutos(double minutos)
{
	this.minutos = minutos;
}

	
public void setHoras(double hora)
{
	this.horas = hora;
}


public double getSegundos()
{
	return this.segundos;
}


public double getMinutos()
{
	return this.minutos;
}


public double getHoras()
{
	return this.horas;
}


public void EjecutarTiempo()
{
if (getSegundos()>=60)
{
setMinutos(getMinutos()+1);
setSegundos(0);
}

if (getMinutos()>=60)
{
setHoras(getHoras()+1);
setMinutos(0);
}
}


 
}
 
