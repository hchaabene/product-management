package org.exoplatform.training.plugins;
import org.exoplatform.services.log.ExoLogger;
import org.exoplatform.services.log.Log;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements ProductPluginInterface {
  private static final Log   LOG     = ExoLogger.getLogger(ProductServiceImpl.class);
  private final  List<textUpperCasePlugin> plugins = new ArrayList<textUpperCasePlugin>();

  @Override
  public String displayText(String text) {
    for(textUpperCasePlugin plugin : plugins) {
      text = plugin.UpperCaseText(text);
      LOG.info("Transformed Text by {} : {}", plugin.getName(), text);
    }
    LOG.info("Final Text : {}", text);
    return text;
  }

  @Override
  public void addPlugins(textUpperCasePlugin text) {
      plugins.add(text);
  }

}
