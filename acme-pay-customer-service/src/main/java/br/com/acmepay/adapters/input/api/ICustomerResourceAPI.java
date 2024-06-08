package br.com.acmepay.adapters.input.api;

import br.com.acmepay.adapters.input.api.request.CustomerRequest;
import br.com.acmepay.adapters.input.api.response.CustomerResponse;

public interface ICustomerResourceAPI {

    CustomerResponse create(CustomerRequest request);
}
