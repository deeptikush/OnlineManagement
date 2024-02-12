package com.orderApplication.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="order_line_table")
@Data
public class OrderLine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_line_id")
	private int orderLineId;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="quantity")
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name="order_id")
	private Order order;
}
