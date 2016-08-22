package org.odin.service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class BaseService<DTOType, EntityType> {

  private DozerBeanMapper mapper;

  public BaseService(DozerBeanMapper mapper) {
    this.mapper=mapper;
  }

  protected void copyProperties(Object source, Object target) {
    mapper.map(source, target);
  }

  protected void copyProperties(Object source, Object target, String mapId) {
    mapper.map(source, target, mapId);
  }

  protected Mapper getMapper() {
    return mapper;
  }

  protected DTOType translate(EntityType object) {
    if (object == null)
      return null;
    DTOType dto;
    try {
      dto = getDTO();
      copyProperties(object, dto);
      return dto;
    } catch (InstantiationException | IllegalAccessException e) {
      throw new UnsupportedOperationException(e);
    }
  }

  protected List<DTOType> translate(List<EntityType> objects) {
    if (objects == null)
      return null;
    return Lists.newArrayList(Lists.transform(objects, listTranslate));
  }

  protected List<DTOType> translate(Iterable<EntityType> objects) {
    if (objects == null)
      return null;
    return Lists.newArrayList(Lists.transform(Lists.newArrayList(objects), listTranslate));
  }

  protected List<DTOType> translate(Page<EntityType> objects) {
    if (objects == null)
      return null;
    return Lists.newArrayList(Lists.transform(objects.getContent(), listTranslate));
  }

  @SuppressWarnings("unchecked")
  protected DTOType getDTO() throws InstantiationException, IllegalAccessException {
    return ((Class<DTOType>) ((ParameterizedType) this.getClass()
        .getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
  }

  @SuppressWarnings("unchecked")
  protected Object getDTO(Class clazz) throws InstantiationException, IllegalAccessException {
    return clazz.newInstance();
  }

  protected Function<EntityType, DTOType> listTranslate = new Function<EntityType, DTOType>() {
    @Override
    public DTOType apply(EntityType object) {
      return translate(object);
    }
  };

}
