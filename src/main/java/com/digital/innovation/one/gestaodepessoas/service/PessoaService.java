package com.digital.innovation.one.gestaodepessoas.service;

import com.digital.innovation.one.gestaodepessoas.dto.MessageResponseDTO;
import com.digital.innovation.one.gestaodepessoas.dto.request.PessoaDTO;
import com.digital.innovation.one.gestaodepessoas.entity.Pessoa;
import com.digital.innovation.one.gestaodepessoas.exception.PessoaNaoEncontradaException;
import com.digital.innovation.one.gestaodepessoas.mapper.PessoaMapper;
import com.digital.innovation.one.gestaodepessoas.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    public MessageResponseDTO createPessoa(PessoaDTO pessoaDTO){
        Pessoa conversaoPessoa = pessoaMapper.toModel(pessoaDTO);
        Pessoa savedPessoa = pessoaRepository.save(conversaoPessoa);
        return metodoMessageMelhorado(savedPessoa.getId(), "Pessoa criada com id ");
    }
    public List<PessoaDTO> getAllPessoas(){
        List<Pessoa> listAllPessoas = pessoaRepository.findAll();
        return listAllPessoas.stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }
//    ================= método get de vários modelos ==================
//     método normal funcionando
//@ResponseStatus(HttpStatus.NOT_FOUND)
//public PessoaDTO findById(Long id) throws PessoaNaoEncontradaException {
//    Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
//    if (optionalPessoa.isEmpty()){
//        throw new PessoaNaoEncontradaException(id);
//    }
//    return pessoaMapper.toDTO(optionalPessoa.get());
//}
//    // método com lambda
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public PessoaDTO findById(Long id) throws PessoaNaoEncontradaException {
//        Pessoa pessoa =  pessoaRepository.findById(id)
//                .orElseThrow(() -> new PessoaNaoEncontradaException(id));
//        return pessoaMapper.toDTO(pessoa);
//    }
// método usando o método de verificação do id
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public PessoaDTO findById(Long id) throws PessoaNaoEncontradaException {
    Pessoa pessoa = verifyIfExists(id);
    return pessoaMapper.toDTO(pessoa);
}
//    ================= fim===========================



    public void deleteById(Long id) throws PessoaNaoEncontradaException {
        pessoaRepository.deleteById(id);

    }
// ================== método update varios maodelos ==================
    // método normal já funcionando
    // separaçaõ do message pois já repetia na criação de uma pessoa
    // clicar com o botão direito com o método selecionado e refactor/extract metod
// 1   public MessageResponseDTO updatePessoa(Long id, PessoaDTO pessoaDTO) throws PessoaNaoEncontradaException {
//        verifyIfExists(id);
//        Pessoa conversaoPessoa = pessoaMapper.toModel(pessoaDTO);
//        Pessoa updatePessoa = pessoaRepository.save(conversaoPessoa);
//        return MessageResponseDTO
//                .builder()
//                .message("Pessoa atualizada com id " + updatePessoa.getId())
//                .build();
//    }

//  2  public MessageResponseDTO updatePessoa(Long id, PessoaDTO pessoaDTO) throws PessoaNaoEncontradaException {
//        verifyIfExists(id);
//        Pessoa conversaoPessoa = pessoaMapper.toModel(pessoaDTO);
//        Pessoa updatePessoa = pessoaRepository.save(conversaoPessoa);
//        return metodoMessageMelhorado(updatePessoa, "Pessoa atualizada com id ");
//    }

    public MessageResponseDTO updatePessoa(Long id, PessoaDTO pessoaDTO) throws PessoaNaoEncontradaException {
        verifyIfExists(id);
        Pessoa conversaoPessoa = pessoaMapper.toModel(pessoaDTO);
        Pessoa updatePessoa = pessoaRepository.save(conversaoPessoa);
        return metodoMessageMelhorado(updatePessoa.getId(), "Pessoa atualizada com id ");
    }

//  2  private MessageResponseDTO metodoMessageMelhorado(Pessoa updatePessoa, String s) {
//        return MessageResponseDTO
//                .builder()
//                .message(s + updatePessoa.getId())
//                .build();
//    }
    private MessageResponseDTO metodoMessageMelhorado(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

    // método criado para encontrar pessoas sem ter que reescrever o mesmo códio para outros métodos
    private Pessoa verifyIfExists(Long id) throws PessoaNaoEncontradaException{
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new PessoaNaoEncontradaException(id));
    }

}
