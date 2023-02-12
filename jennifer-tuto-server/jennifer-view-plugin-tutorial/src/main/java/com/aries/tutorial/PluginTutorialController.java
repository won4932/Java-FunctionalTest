package com.aries.tutorial;

import com.aries.extension.starter.PluginController;
import com.aries.extension.util.ConfigUtil;
import com.aries.extension.util.LogUtil;
import com.aries.extension.util.PropertyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PluginTutorialController extends PluginController {

    @RequestMapping(value = { "/tutorial" }, method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView getMainPage(ModelMap modelMap, @RequestParam(required=false, defaultValue="") String layout) {
        // TODO: layout 매개변수에 따라 다른 템플릿을 적용한다.
        // Apply a different template according to the layout parameter.
        ModelAndView mav = new ModelAndView(layout.equals("iframe") ? "templates/iframe.vm" : "templates/main.vm");

        // TODO: 어댑터 & 실험실 관리 화면에서 추가한 플러그인에 대한 옵션을 가져올 수 있다.
        // Retrieve an option set in the  Adapter and Plugin screen
        String property = PropertyUtil.getValue("plugin_tutorial", "db_path", "../db_path_property");

        // TODO: server_view.conf 파일에 설정된 뷰서버 옵션을 가져올 수 있다.
        // Retrieve a view server option set in server_view.conf file
        String config = ConfigUtil.getValue("db_path", "../db_path_config");

        // TODO: 플러그인의 로그를 남기는 유틸리티 클래스를 제공한다.
        // Utility class used for loggin
        LogUtil.info(property + ", " + config);

        // TODO: 템플릿에서 사용할 데이터를 넘길 수 있다.
        modelMap.put("copyright", "Copyright © 2019 JenniferSoft Inc. All rights reserved.");

        return mav;
    }
}