package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	private Integer quarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva() {
	}

	public Reserva(Integer quarto, Date checkIn, Date checkOut) {
		this.quarto = quarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getQuarto() {
		return quarto;
	}

	public void setQuarto(Integer quarto) {
		this.quarto = quarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duracao() {
		long dif = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	
	public String atualizar(Date checkIn, Date checkOut) {
		
		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(agora)) {
			return "Erro na Reserva: as datas de atualização devem ser maiores que a atual!";
		} 
		if (!checkOut.after(checkIn)) {
			return "Erro na Reserva: a data de chekout deve ser superior a de chekin!";
		}
		
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}
	
	@Override
	public String toString() {
		return "Quarto " + quarto + ", chekin: " + sdf.format(checkIn) + ", " + sdf.format(checkOut) + ", duração: "
				+ duracao() + " noites";
	}

}
