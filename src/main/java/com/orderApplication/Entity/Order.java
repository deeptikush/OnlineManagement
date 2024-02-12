package com.orderApplication.Entity;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="order_table")
@Data
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private int id;
	
	@Column(name ="amount")
	private long amount;

	@Column(name="order_name")
	private String orderName;

	@OneToMany(mappedBy = "order",cascade = CascadeType.REMOVE)
	private List<OrderLine> orderLines;
	
	
	

}
