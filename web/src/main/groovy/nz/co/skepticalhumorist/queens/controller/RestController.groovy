package nz.co.skepticalhumorist.queens.controller

import groovy.util.logging.Slf4j
import nz.co.skepticalhumorist.queens.domain.Board
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@Slf4j
@Controller
@RequestMapping("/rest")
class RestController {

  @RequestMapping(value="/one/{size}", method=RequestMethod.GET)
  @ResponseBody
  List<String> listCategoriesForGroup(@PathVariable("size") int size) {
    log.info("one($size)")
    Board board = new Board(size)
    board.solve()
    board.cols
  }

}
