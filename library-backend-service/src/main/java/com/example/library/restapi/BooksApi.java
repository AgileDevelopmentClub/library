/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (4.1.3).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.library.restapi;

import com.example.library.restapi.dto.BooksDto;
import com.example.library.restapi.dto.InventorysDto;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2019-12-08T00:26:11.023326300+09:00[Asia/Tokyo]")

@Validated
@Api(value = "books", description = "the books API")
public interface BooksApi {

    @ApiOperation(value = "本を検索する", nickname = "booksGet", notes = "", response = BooksDto.class, tags={ "books", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = BooksDto.class) })
    @RequestMapping(value = "/books",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<BooksDto> booksGet();


    @ApiOperation(value = "棚卸対象の一覧を取得する", nickname = "booksInventoryVersionGet", notes = "", response = InventorysDto.class, tags={ "books","inventory", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "OK", response = InventorysDto.class) })
    @RequestMapping(value = "/books/inventory/{version}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<InventorysDto> booksInventoryVersionGet(@ApiParam(value = "棚卸のバージョン", required = true) @PathVariable("version") Integer version);


    @ApiOperation(value = "誤って登録した棚卸を取り消す", nickname = "booksInventoryVersionIsbnDelete", notes = "", tags={ "books","inventory", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Not Implemented") })
    @RequestMapping(value = "/books/inventory/{version}/{isbn}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> booksInventoryVersionIsbnDelete(@ApiParam(value = "棚卸のバージョン", required = true) @PathVariable("version") Integer version, @ApiParam(value = "棚卸対象のISBN", required = true) @PathVariable("isbn") Integer isbn);


    @ApiOperation(value = "本を棚卸する", nickname = "booksInventoryVersionIsbnPut", notes = "", tags={ "books","inventory", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Not Implemented") })
    @RequestMapping(value = "/books/inventory/{version}/{isbn}",
        method = RequestMethod.PUT)
    ResponseEntity<Void> booksInventoryVersionIsbnPut(@ApiParam(value = "棚卸のバージョン", required = true) @PathVariable("version") Integer version, @ApiParam(value = "棚卸対象のISBN", required = true) @PathVariable("isbn") Integer isbn);


    @ApiOperation(value = "パラメータのISBNの棚卸を開始する", nickname = "booksInventoryVersionPut", notes = "", tags={ "books","inventory", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "棚卸") })
    @RequestMapping(value = "/books/inventory/{version}",
        method = RequestMethod.PUT)
    ResponseEntity<Void> booksInventoryVersionPut(@ApiParam(value = "棚卸のバージョン", required = true) @PathVariable("version") Integer version);


    @ApiOperation(value = "", nickname = "booksIsbnDelete", notes = "", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Not Implemented") })
    @RequestMapping(value = "/books/{isbn}",
        method = RequestMethod.DELETE)
    ResponseEntity<Void> booksIsbnDelete(@ApiParam(value = "", required = true) @PathVariable("isbn") String isbn);


    @ApiOperation(value = "本を登録する", nickname = "booksIsbnPut", notes = "", tags={ "books", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Not Implemented") })
    @RequestMapping(value = "/books/{isbn}",
        method = RequestMethod.PUT)
    ResponseEntity<Void> booksIsbnPut(@ApiParam(value = "", required = true) @PathVariable("isbn") String isbn);

}
