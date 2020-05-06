package com.evolvus.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("LOOKUP")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lookup {
	@Id
	private int lookupId;
	private String lookupType;
	private String lookupCode;
	private String lookupValue;

}
