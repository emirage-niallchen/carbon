package top.emirage.carbon.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import top.emirage.carbon.entity.*;
import top.emirage.carbon.service.Impl.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author ChenBoyun
 * @date 2023-03-24 21:19
 */
@RestController
@RequestMapping("/excel")
public class ExcelExportController {

    @Autowired
    private WasteServiceImpl wasteService;
    @GetMapping("/export/waste")
    public void exportwasteExcel(HttpServletResponse response) {
        try {
            this.setExcelResponseProp(response, "废弃物列表");
            List<Waste> list = wasteService.list();
            EasyExcel.write(response.getOutputStream())
                    .head(Waste.class)
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet("废弃物列表")
                    .doWrite(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Autowired
    private Plant_coverServiceImpl plant_coverService;
    @GetMapping("/export/plant_cover")
    public void exportplant_coverExcel(HttpServletResponse response) {
        try {
            this.setExcelResponseProp(response, "碳汇列表");
            List<Plant_cover> list = plant_coverService.list();
            EasyExcel.write(response.getOutputStream())
                    .head(Plant_cover.class)
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet("碳汇列表")
                    .doWrite(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Autowired
    private IndustrialServiceImpl industrialService;
    @GetMapping("/export/industrial")
    public void exportindustrialExcel(HttpServletResponse response) {
        try {
            this.setExcelResponseProp(response, "工业生产列表");
            List<Industrial> list = industrialService.list();
            EasyExcel.write(response.getOutputStream())
                    .head(Industrial.class)
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet("工业品列表")
                    .doWrite(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Autowired
    private HusbandryServiceImpl husbandryService;
    @GetMapping("/export/husbandry")
    public void exporthusbandryExcel(HttpServletResponse response) {
        try {
            this.setExcelResponseProp(response, "牲畜列表");
            List<Husbandry> list = husbandryService.list();
            EasyExcel.write(response.getOutputStream())
                    .head(Husbandry.class)
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet("牲畜列表")
                    .doWrite(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Autowired
    private BasicServiceImpl basicService;
    @GetMapping("/export/basic")
    public void exportbasicExcel(HttpServletResponse response) {
        try {
            this.setExcelResponseProp(response, "经济人口列表");
            List<Basic> list = basicService.list();
            EasyExcel.write(response.getOutputStream())
                    .head(Basic.class)
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet("基本经济人口列表")
                    .doWrite(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Autowired
    private AgricultureServiceImpl agricultureService;
    @GetMapping("/export/agriculture")
    public void exportagricultureExcel(HttpServletResponse response) {
        try {
            this.setExcelResponseProp(response, "耕作列表");
            List<Agriculture> list = agricultureService.list();
            EasyExcel.write(response.getOutputStream())
                    .head(Agriculture.class)
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet("耕作列表")
                    .doWrite(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @Autowired
    private EnergyServiceImpl energyService;
    @GetMapping("/export/energy")
    public void exportEnergyExcel(HttpServletResponse response) {
        try {
            this.setExcelResponseProp(response, "能源消费列表");
            List<Energy> list = energyService.list();
            EasyExcel.write(response.getOutputStream())
                    .head(Energy.class)
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet("能源消费列表")
                    .doWrite(list);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 设置响应结果
     *
     * @param response    响应结果对象
     * @param rawFileName 文件名
     * @throws UnsupportedEncodingException 不支持编码异常
     */
    private void setExcelResponseProp(HttpServletResponse response, String rawFileName) throws UnsupportedEncodingException {
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode(rawFileName, "UTF-8").replaceAll("/", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
    }

    /**
     * 读取用户列表数据
     *
     * @return 用户列表数据
     * @throws IOException IO异常
     */
//    private List<UserDO> getUserList() throws IOException {
//        ObjectMapper objectMapper = new ObjectMapper();
//        ClassPathResource classPathResource = new ClassPathResource("mock/users.json");
//        InputStream inputStream = classPathResource.getInputStream();
//        return objectMapper.readValue(inputStream, new TypeReference<List<UserDO>>() {
//        });
    }


