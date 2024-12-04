
import com.ei.dingdingTalk.controller.ReduceDataController;
import com.ei.dingdingTalk.service.DeduceDataService;
import com.ei.util.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReduceDataControllerTest {

    @Mock
    private DeduceDataService b2bDataService;

    @Mock
    private DeduceDataService ztthDataService;

    @InjectMocks
    private ReduceDataController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void thirdPartyDataCollect_Success() {
        // Arrange
        List<String> b2bList = Arrays.asList("b2b1", "b2b2");
        List<String> ztthList = Arrays.asList("ztth1", "ztth2");

        when(b2bDataService.getThirdPartyData())
                .thenReturn(CompletableFuture.completedFuture(b2bList));
        when(ztthDataService.getThirdPartyData())
                .thenReturn(CompletableFuture.completedFuture(ztthList));

        // Act
        Result result = controller.thirdPartyDataCollect();

        // Assert
        assertNotNull(result);
//        assertEquals("success", result.());
        verify(b2bDataService, times(1)).getThirdPartyData();
        verify(ztthDataService, times(1)).getThirdPartyData();
    }

    @Test
    void thirdPartyDataCollect_HandleException() {
        // Arrange
        when(b2bDataService.getThirdPartyData())
                .thenReturn(CompletableFuture.failedFuture(new RuntimeException("Test exception")));
        when(ztthDataService.getThirdPartyData())
                .thenReturn(CompletableFuture.completedFuture(Arrays.asList("ztth1")));

        // Act
        Result result = controller.thirdPartyDataCollect();

        // Assert
        assertNotNull(result);
//        assertEquals("success", result.getMsg());
        verify(b2bDataService, times(1)).getThirdPartyData();
        verify(ztthDataService, times(1)).getThirdPartyData();
    }
}