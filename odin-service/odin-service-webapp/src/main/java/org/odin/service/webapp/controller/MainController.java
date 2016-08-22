package org.odin.service.webapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
class MainController implements BaseController {

  @Value("${app.asset-host}")
  private String assetsHost;

  @SuppressWarnings("UnusedDeclaration")
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    private final AssetManifestService assetManifestService;

    @Autowired
    public MainController(AssetManifestService assetManifestService) {
        this.assetManifestService = assetManifestService;
    }

    @RequestMapping({"/**"})
    public String index(Model model) {
        model.addAttribute("assetHost", assetsHost);
        model.addAttribute("manifest", assetManifestService.fetchAssetManifest());
        return "index";
    }

}
