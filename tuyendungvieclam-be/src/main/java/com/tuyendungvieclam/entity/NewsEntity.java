package com.tuyendungvieclam.entity;


import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "news")
public class NewsEntity extends BaseEntity {

	@Id
	@Column(name = "new_id")
	private String newId;
	
	@Column(name = "short_description", columnDefinition = "TEXT")
	private String shortDescription;
	
	@Column(name = "tenCongTy")
	private String tenCongTy;
	
	@Column(name = "hanNopHoSo")
	private String hanNopHoSo;
	
	@Column(name = "mucLuong")
	private int mucLuong;
	
	@Column(name = "hinhThucLamViec")
	private String hinhThucLamViec;
	
	@Column(name = "content", columnDefinition = "TEXT", length = 100000)
	private String content;
	
	@Column(name = "images")
	private String images;
	
	@Column(name = "soLuongTuyen")
	private int soLuongTuyen;
	
	@Column(name = "capBac")
	private String capBac;
	
	@Column(name = "kinhNghiem")
	private String kinhNghiem;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_name")
	private UserEntity user;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "newInfo")
	private List<CommentEntity> comments;

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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}

	
	
}
