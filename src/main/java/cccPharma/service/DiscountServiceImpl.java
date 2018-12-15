package cccPharma.service;

import cccPharma.dao.DiscountRepository;
import cccPharma.model.Discount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountServiceImpl implements DiscountService{

    @Autowired
    private DiscountRepository discountRepository;

    @Override
    public Discount SaveOrUpdate(Discount discount) {
        for(Discount d : discountRepository.findAll()) {
            if(d.equals(discount)) {
                return d;
            }
        }
        discountRepository.save(discount);
        return discount;
    }
}
