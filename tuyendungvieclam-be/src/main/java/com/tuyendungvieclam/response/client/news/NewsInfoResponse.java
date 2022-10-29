package com.tuyendungvieclam.response.client.news;

import com.tuyendungvieclam.dto.NewsDTO;

public class NewsInfoResponse {

	private String newId;

	private String shortDescription;

	private String tenCongTy;

	private String hanNopHoSo;

	private int mucLuong;

	private String hinhThucLamViec;

	private int soLuongTuyen;

	private String capBac;

	private String kinhNghiem;

	private String content;

	private String images;

	public String getNewId() {
		return newId;
	}

	public void setNewId(String newId) {
		this.newId = newId;
	}

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

	public static NewsInfoResponse copy(NewsDTO newsDTO) {
		NewsInfoResponse result = new NewsInfoResponse();
		result.setContent(newsDTO.getContent());
		result.setNewId(newsDTO.getNewId());
		result.setImages(newsDTO.getImages());
		result.setShortDescription(newsDTO.getShortDescription());
		result.setCapBac(newsDTO.getCapBac());
		result.setHanNopHoSo(newsDTO.getHanNopHoSo());
		result.setHinhThucLamViec(newsDTO.getHinhThucLamViec());
		result.setKinhNghiem(newsDTO.getKinhNghiem());
		result.setMucLuong(newsDTO.getMucLuong());
		result.setSoLuongTuyen(newsDTO.getSoLuongTuyen());
		result.setTenCongTy(newsDTO.getTenCongTy());
		return result;
	}

}
