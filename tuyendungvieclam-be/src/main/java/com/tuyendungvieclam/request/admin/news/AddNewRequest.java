package com.tuyendungvieclam.request.admin.news;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddNewRequest {

	@JsonProperty("short_description")
	private String shortDescription;

	@JsonProperty("tenCongTy")
	private String tenCongTy;

	@JsonProperty("hanNopHoSo")
	private String hanNopHoSo;

	@JsonProperty("mucLuong")
	private int mucLuong;

	@JsonProperty("hinhThucLamViec")
	private String hinhThucLamViec;

	@JsonProperty("content")
	private String content;

	@JsonProperty("images")
	private String images;

	@JsonProperty("soLuongTuyen")
	private int soLuongTuyen;

	@JsonProperty("capBac")
	private String capBac;

	@JsonProperty("kinhNghiem")
	private String kinhNghiem;


	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getTenCongTy() {
		return tenCongTy;
	}

	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}

	public String getHanNopHoSo() {
		return hanNopHoSo;
	}

	public void setHanNopHoSo(String hanNopHoSo) {
		this.hanNopHoSo = hanNopHoSo;
	}

	public int getMucLuong() {
		return mucLuong;
	}

	public void setMucLuong(int mucLuong) {
		this.mucLuong = mucLuong;
	}

	public String getHinhThucLamViec() {
		return hinhThucLamViec;
	}

	public void setHinhThucLamViec(String hinhThucLamViec) {
		this.hinhThucLamViec = hinhThucLamViec;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getSoLuongTuyen() {
		return soLuongTuyen;
	}

	public void setSoLuongTuyen(int soLuongTuyen) {
		this.soLuongTuyen = soLuongTuyen;
	}

	public String getCapBac() {
		return capBac;
	}

	public void setCapBac(String capBac) {
		this.capBac = capBac;
	}

	public String getKinhNghiem() {
		return kinhNghiem;
	}

	public void setKinhNghiem(String kinhNghiem) {
		this.kinhNghiem = kinhNghiem;
	}
}
