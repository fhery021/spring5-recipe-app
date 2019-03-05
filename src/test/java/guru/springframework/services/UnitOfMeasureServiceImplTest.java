package guru.springframework.services;

import guru.springframework.commands.UnitOfMeasureCommand;
import guru.springframework.converters.UnitOfMeasureToUnitOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import guru.springframework.repositories.UnitOfMeasureRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UnitOfMeasureServiceImplTest {

    UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureToUnitOfMeasureCommand = new UnitOfMeasureToUnitOfMeasureCommand();
    UnitOfMeasureService service;

    @Mock
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        service = new UnitOfMeasureServiceImpl(unitOfMeasureRepository, unitOfMeasureToUnitOfMeasureCommand);
    }

    @Test
    public void listAllUOMsTest(){
        // given
        UnitOfMeasure tableSpoon = new UnitOfMeasure();
        tableSpoon.setId(1L);
        tableSpoon.setDescription("tablespoon");
        UnitOfMeasure dash = new UnitOfMeasure();
        dash.setId(2L);
        dash.setDescription("dash");
        UnitOfMeasure teaSpoon = new UnitOfMeasure();
        teaSpoon.setId(3L);
        teaSpoon.setDescription("teaspoon");

        Set<UnitOfMeasure> unitOfMeasures = new HashSet<>();
        unitOfMeasures = Stream.of(tableSpoon, dash, teaSpoon).collect(Collectors.toSet());

        // when
        when(unitOfMeasureRepository.findAll()).thenReturn(unitOfMeasures);

        // then
        Set<UnitOfMeasureCommand> unitOfMeasureCommands = service.listAllUOMs();

        assertNotNull(unitOfMeasureCommands);
        assertTrue(!unitOfMeasureCommands.isEmpty());
        assertEquals(3, unitOfMeasureCommands.size());
        verify(unitOfMeasureRepository, times(1)).findAll();
    }

}