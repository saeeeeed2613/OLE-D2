package com.orange.TAMicroservice.mapper;

import org.mapstruct.Mapper;

import com.orange.TAMicroservice.domain.Report;
import com.orange.TAMicroservice.web.model.ReportDto;



@Mapper(uses= {DateMapper.class})
public interface ReportMapper {

	ReportDto reportToReportDto(Report report);
	Report reportDtoToReport(ReportDto reportDto);
}
