/**
 * Copyright 2016 SivaLabs.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, 
 * software distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions 
 * and limitations under the License.
 */
package demo;

import java.math.BigDecimal;

/**
 * @author Siva
 *
 */
public class Product
{
	private String code;
	private String title;
	private String description;
	private BigDecimal price;
	private String brand;
	private String category;
	
	public Product()
	{
	}

	public Product(String code, String title, String description, BigDecimal price, String brand, String category)
	{
		this.code = code;
		this.title = title;
		this.description = description;
		this.price = price;
		this.brand = brand;
		this.category = category;
	}

	@Override
	public String toString()
	{
		return "Product [code=" + code + ", title=" + title + ", description=" + description + ", price=" + price
		        + ", brand=" + brand + ", category=" + category + "]";
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public void setPrice(BigDecimal price)
	{
		this.price = price;
	}

	public String getBrand()
	{
		return brand;
	}

	public void setBrand(String brand)
	{
		this.brand = brand;
	}

	public String getCategory()
	{
		return category;
	}

	public void setCategory(String category)
	{
		this.category = category;
	}
	
}
